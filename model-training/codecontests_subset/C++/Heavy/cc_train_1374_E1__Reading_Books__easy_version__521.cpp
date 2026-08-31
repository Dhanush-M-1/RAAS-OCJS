#include <bits/stdc++.h>
using namespace std;
long long int const mod = 1000000007;
std::mt19937 rng(
    (int)std::chrono::steady_clock::now().time_since_epoch().count());
int rand_rng(int l, int r) {
  uniform_int_distribution<int> p(l, r);
  return p(rng);
}
long long int power(long long int x, long long int y, long long int m) {
  long long int temp;
  if (y == 0) return 1;
  temp = power(x, y / 2, m) % m;
  if (y % 2 == 0)
    return ((temp) * (temp)) % m;
  else
    return (((x) % m) * ((temp * temp) % m)) % m;
}
int const N = 200009;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int T;
  T = 1;
  while (T--) {
    long long int n, m, k, t, a, b;
    cin >> n >> m >> k;
    set<pair<long long int, long long int> > fre, st;
    vector<pair<long long int, long long int> > aa, bb, ab, zz;
    for (int i = 0; i < (int)n; i++) {
      cin >> t >> a >> b;
      if (a && b) {
        ab.push_back({t, i + 1});
      } else if (a) {
        aa.push_back({t, i + 1});
      } else if (b) {
        bb.push_back({t, i + 1});
      } else {
        fre.insert({t, i + 1});
        zz.push_back({t, i + 1});
      }
    }
    sort(aa.begin(), aa.end());
    ;
    sort(bb.begin(), bb.end());
    ;
    sort(ab.begin(), ab.end());
    ;
    sort(zz.begin(), zz.end());
    ;
    int ind = -1;
    long long int sum = 0;
    long long int ans = 100000000000000000;
    long long int tempsum = 0;
    long long int out = 0;
    for (int i = 0; i <= ab.size(); i++) {
      long long int temp = k - i;
      if (i > m) break;
      if (i) {
        sum += ab[i - 1].first;
      }
      if (aa.size() >= temp && bb.size() >= temp && i + 2 * temp <= m &&
          n - (ab.size() - i) >= m) {
        if (ind == -1) {
          for (int j = 0; j < (int)temp; j++) sum += aa[j].first + bb[j].first;
          for (int j = max(0ll, temp); j < aa.size(); j++) fre.insert(aa[j]);
          for (int j = max(0ll, temp); j < bb.size(); j++) fre.insert(bb[j]);
          ind = i;
          temp = max(0ll, temp);
          long long int dif = m - i - 2 * temp;
          while (st.size() < dif && fre.size()) {
            tempsum += (fre.begin())->first;
            st.insert(*(fre.begin()));
            fre.erase(*(fre.begin()));
          }
          ans = min(ans, sum + tempsum);
          out = i;
        } else {
          if (temp >= 0) sum -= aa[temp].first + bb[temp].first;
          if (temp >= 0) {
            fre.insert(aa[temp]);
            fre.insert(bb[temp]);
          }
          temp = max(0ll, temp);
          long long int dif = m - i - 2 * temp;
          while (st.size() && st.size() > dif) {
            tempsum -= (st.rbegin())->first;
            fre.insert(*(st.rbegin()));
            st.erase(*(st.rbegin()));
          }
          while (st.size() < dif && fre.size()) {
            tempsum += (fre.begin())->first;
            st.insert(*(fre.begin()));
            fre.erase(*(fre.begin()));
          }
          while (st.size() && fre.size() && *(st.rbegin()) > *(fre.begin())) {
            st.insert(*(fre.begin()));
            tempsum += (fre.begin())->first;
            fre.erase(*(fre.begin()));
            fre.insert(*(st.rbegin()));
            tempsum -= (st.rbegin())->first;
            st.erase(*(st.rbegin()));
          }
          if (sum + tempsum < ans) out = i;
          ans = min(ans, sum + tempsum);
        }
      }
    }
    if (ind == -1) {
      cout << "-1\n";
    } else {
      ans = 0;
      vector<long long int> p;
      long long int temp = k - out;
      for (int i = 0; i < (int)out; i++) {
        p.push_back(ab[i].second);
        ans += ab[i].first;
      }
      for (int i = 0; i < (int)temp; i++) {
        p.push_back(aa[i].second);
        ans += aa[i].first;
      }
      for (int i = 0; i < (int)temp; i++) {
        p.push_back(bb[i].second);
        ans += bb[i].first;
      }
      fre.clear();
      for (int x = out; x < ab.size(); x++) fre.insert(ab[x]);
      for (auto i : zz) fre.insert(i);
      temp = max(0ll, temp);
      for (int i = temp; i < aa.size(); i++) fre.insert(aa[i]);
      for (int i = temp; i < bb.size(); i++) fre.insert(bb[i]);
      long long int dif = m - out - 2 * temp;
      while (dif > 0) {
        dif--;
        p.push_back((fre.begin())->second);
        ans += (fre.begin())->first;
        fre.erase(*(fre.begin()));
      }
      cout << ans << "\n";
      for (auto j : p) cout << j << " ";
    }
  }
}
