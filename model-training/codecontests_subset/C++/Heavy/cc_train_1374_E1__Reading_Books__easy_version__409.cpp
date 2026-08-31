#include <bits/stdc++.h>
using namespace std;
vector<pair<long long, long long> > al, bob, both, v, ansb, alr, bobr, norr, vc,
    neither;
set<long long> ans;
int vis[200005], l1[200005], l2[200005];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long a = 0, b = 0, c, d, e, f = 0, g, m, n, k, i, j, t, in, p, q, l, r;
  cin >> n >> m >> k;
  vc.push_back({0, 0});
  for (i = 0; i < n; i++) {
    cin >> p >> a >> b;
    l1[i + 1] = a;
    l2[i + 1] = b;
    v.push_back({p, i + 1});
    vc.push_back({p, i + 1});
    if (a && b) {
      both.push_back({p, i + 1});
    } else if (a)
      al.push_back({p, i + 1});
    else if (b)
      bob.push_back({p, i + 1});
  }
  sort(both.begin(), both.end());
  sort(bob.begin(), bob.end());
  sort(al.begin(), al.end());
  sort(v.begin(), v.end());
  if (both.size() + bob.size() < k || both.size() + al.size() < k) {
    cout << -1 << '\n';
    return 0;
  }
  for (i = 1; i < both.size(); i++) {
    both[i].first += both[i - 1].first;
  }
  for (i = 1; i < bob.size(); i++) {
    bob[i].first += bob[i - 1].first;
  }
  for (i = 1; i < al.size(); i++) {
    al[i].first += al[i - 1].first;
  }
  if (al.size() >= k && bob.size() >= k && m >= k * 2 && both.size() == 0) {
    f = al[k - 1].first + bob[k - 1].first;
    p = k;
    q = k;
    r = 0;
  } else {
    p = 0;
    q = 0;
    r = 0;
    f = 9999999999999999;
  }
  l = both.size();
  l = min(l, m);
  for (i = l - 1; i >= l - 1 && i >= 0; i--) {
    d = max(0LL, k - i - 1);
    if (d > 0 && (d > al.size() || d > bob.size())) break;
    if (d * 2 + i + 1 > m) break;
    c = both[i].first;
    if (d > 0) c += al[d - 1].first + bob[d - 1].first;
    f = c;
    p = max(0LL, d);
    q = max(0LL, d);
    r = i + 1;
  }
  if (f == 9999999999999999) {
    cout << -1 << '\n';
    return 0;
  }
  for (i = 0; i < p; i++) {
    ans.insert(al[i].second);
    vis[al[i].second] = 1;
  }
  for (i = 0; i < q; i++) {
    ans.insert(bob[i].second);
    vis[bob[i].second] = 1;
  }
  for (i = 0; i < r; i++) {
    ans.insert(both[i].second);
    ansb.push_back(vc[both[i].second]);
    vis[both[i].second] = 1;
  }
  i = 0;
  while (ans.size() < m) {
    if (vis[v[i].second]) {
      i++;
      continue;
    } else {
      f += v[i].first;
      ans.insert(v[i].second);
      vis[v[i].second] = 1;
      if (l1[v[i].second] && l2[v[i].second]) ansb.push_back(v[i]);
      i++;
    }
  }
  sort(ansb.begin(), ansb.end());
  for (i = 0; i < n; i++) {
    if (!vis[v[i].second]) {
      p = v[i].second;
      if (l1[p] && l2[p])
        ;
      else if (l1[p])
        alr.push_back(v[i]);
      else if (l2[p])
        bobr.push_back(v[i]);
      else
        norr.push_back(v[i]);
    } else if (!l1[v[i].second] && !l2[v[i].second]) {
      neither.push_back(v[i]);
    }
  }
  sort(alr.begin(), alr.end());
  reverse(alr.begin(), alr.end());
  sort(bobr.begin(), bobr.end());
  reverse(bobr.begin(), bobr.end());
  sort(norr.begin(), norr.end());
  reverse(norr.begin(), norr.end());
  sort(neither.begin(), neither.end());
  p = 0;
  q = 0;
  for (auto it : ans) {
    if (l1[it]) p++;
    if (l2[it]) q++;
  }
  while (ansb.size() > 0) {
    if (p - 1 < k && q - 1 < k) {
      if (neither.size() == 0 || alr.size() == 0 || bobr.size() == 0) break;
      long long c1 = ansb.back().first + neither.back().first;
      long long c2 = alr.back().first + bobr.back().first;
      if (c2 < c1) {
        ans.erase(ansb.back().second);
        ans.erase(neither.back().second);
        norr.push_back(neither.back());
        ansb.pop_back();
        neither.pop_back();
        f -= c1;
        f += c2;
        ans.insert(alr.back().second);
        ans.insert(bobr.back().second);
        alr.pop_back();
        bobr.pop_back();
      } else
        break;
    } else {
      c = ansb.back().first;
      in = ansb.back().second;
      long long mn = 99999999999;
      if (p - 1 < k) {
        if (!alr.size()) break;
        mn = alr.back().first;
        if (mn < c) {
          q--;
          ans.erase(in);
          ans.insert(alr.back().second);
          alr.pop_back();
          ansb.pop_back();
          f -= c;
          f += mn;
        } else
          break;
      } else if (q - 1 < k) {
        if (!bobr.size()) break;
        mn = bobr.back().first;
        if (mn < c) {
          p--;
          ans.erase(in);
          ans.insert(bobr.back().second);
          bobr.pop_back();
          f -= c;
          f += mn;
          ansb.pop_back();
        } else
          break;
      } else {
        mn = c;
        int fl = 0;
        if (alr.size() && alr.back().first < mn) {
          mn = alr.back().first;
          fl = 1;
        }
        if (bobr.size() && bobr.back().first < mn) {
          mn = bobr.back().first;
          fl = 2;
        }
        if (norr.size() && norr.back().first < mn) {
          mn = norr.back().first;
          fl = 3;
        }
        if (fl == 0)
          break;
        else if (fl == 1) {
          q--;
          ans.erase(in);
          ans.insert(alr.back().second);
          alr.pop_back();
          ansb.pop_back();
          f -= c;
          f += mn;
        } else if (fl == 2) {
          p--;
          ans.erase(in);
          ans.insert(bobr.back().second);
          bobr.pop_back();
          f -= c;
          f += mn;
          ansb.pop_back();
        } else {
          p--;
          q--;
          ans.erase(in);
          ans.insert(norr.back().second);
          neither.push_back(norr.back());
          norr.pop_back();
          f -= c;
          f += mn;
          ansb.pop_back();
        }
      }
    }
  }
  cout << f << '\n';
  for (auto it : ans) cout << it << ' ';
  return 0;
}
