#include <bits/stdc++.h>
using namespace std;
int32_t main() {
  int n, m, k;
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> n >> m >> k;
  vector<pair<int, int> > ab;
  vector<pair<int, int> > a;
  vector<pair<int, int> > b;
  vector<pair<int, int> > non;
  for (int i = 0; i < n; i++) {
    int t, a1, b1;
    cin >> t >> a1 >> b1;
    if (a1 && b1) {
      ab.push_back({t, i});
    } else if (a1) {
      a.push_back({t, i});
    } else if (b1) {
      b.push_back({t, i});
    } else {
      non.push_back({t, i});
    }
  }
  sort(ab.begin(), ab.end());
  sort(a.begin(), a.end());
  sort(b.begin(), b.end());
  sort(non.begin(), non.end());
  int l = -1;
  for (int i = 0; i <= min(k, (int)ab.size()); i++) {
    if (k - i <= (int)a.size() && k - i <= (int)b.size() &&
        ((k - i) * 2 + i <= m)) {
      l = i;
      break;
    }
  }
  if (l == -1) {
    cout << -1;
    return 0;
  }
  set<pair<int, int> > curr;
  set<pair<int, int> > all;
  int r1 = l, r2 = k - l;
  long long ans;
  long long curr_sum = 0;
  int ans_r1 = r1, ans_r2 = r2;
  int curr_el = r2 * 2 + r1;
  for (int i = 0; i < r2; i++) {
    curr_sum += a[i].first;
    curr_sum += b[i].first;
  }
  for (int i = 0; i < r1; i++) {
    curr_sum += ab[i].first;
  }
  for (int i = r2; i < a.size(); i++) {
    all.insert(a[i]);
  }
  for (int i = r2; i < b.size(); i++) {
    all.insert(b[i]);
  }
  for (int i = 0; i < non.size(); i++) {
    all.insert(non[i]);
  }
  for (int i = r1; i < ab.size(); i++) {
    all.insert(ab[i]);
  }
  int add = 0;
  while (curr.size() < (m - curr_el)) {
    curr_sum += (*all.begin()).first;
    curr.insert(*all.begin());
    all.erase(all.begin());
  }
  ans = curr_sum;
  for (int i = l; i < min(k, (int)ab.size()); i++) {
    curr_sum -= a[r2 - 1].first;
    curr_sum -= b[r2 - 1].first;
    curr_sum += ab[r1].first;
    all.insert(a[r2 - 1]);
    all.insert(b[r2 - 1]);
    r2--;
    if (all.find(ab[r1]) != all.end()) {
      all.erase(ab[r1]);
    }
    if (curr.find(ab[r1]) != curr.end()) {
      curr_sum -= ab[r1].first;
      curr.erase(ab[r1]);
    }
    r1++;
    curr_el = r2 * 2 + r1;
    while (curr.size() < (m - curr_el)) {
      curr_sum += (*all.begin()).first;
      curr.insert(*all.begin());
      all.erase(all.begin());
    }
    if (!curr.empty() && !all.empty()) {
      auto curr_last = curr.end();
      curr_last--;
      while (!all.empty() && *curr_last > *all.begin()) {
        curr_sum -= (*curr_last).first;
        curr_sum += (*all.begin()).first;
        all.insert(*curr_last);
        curr.erase(curr_last);
        curr.insert(*all.begin());
        all.erase(all.begin());
        curr_last = curr.end();
        curr_last--;
      }
    }
    if (curr_sum < ans) {
      ans = curr_sum;
      ans_r1 = r1;
      ans_r2 = r2;
    }
  }
  r1 = ans_r1;
  r2 = ans_r2;
  cout << ans << "\n";
  for (int i = 0; i < r1; i++) {
    cout << ab[i].second + 1 << " ";
  }
  for (int i = 0; i < r2; i++) {
    cout << a[i].second + 1 << " ";
    cout << b[i].second + 1 << " ";
  }
  set<pair<int, int> > free;
  for (int i = r2; i < a.size(); i++) {
    free.insert(a[i]);
  }
  for (int i = r2; i < b.size(); i++) {
    free.insert(b[i]);
  }
  for (int i = 0; i < non.size(); i++) {
    free.insert(non[i]);
  }
  for (int i = r1; i < ab.size(); i++) {
    free.insert(ab[i]);
  }
  curr_el = r2 * 2 + r1;
  for (int i = 0; i < (m - curr_el); i++) {
    cout << (*free.begin()).second + 1 << " ";
    free.erase(free.begin());
  }
  return 0;
}
