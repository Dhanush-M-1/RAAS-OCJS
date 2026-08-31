#include <bits/stdc++.h>
using namespace std;
unordered_set<long long> s;
vector<long long> v[1000005 + 5], mult, putin;
long long n, rad, sol;
int main() {
  cin >> n;
  rad = sqrt(n);
  for (long long i = 1; i <= n; i++) {
    long long x, y;
    cin >> x >> y;
    v[x].push_back(y);
    s.insert(x * 1000000LL + y);
  }
  for (long long i = 0; i <= 1000005; i++)
    if (v[i].size() > 0) {
      sort(v[i].begin(), v[i].end());
      if (v[i].size() > rad)
        mult.push_back(i);
      else
        putin.push_back(i);
    }
  for (auto it : putin)
    for (long long i = 0; i < v[it].size(); i++)
      for (long long j = i + 1; j < v[it].size(); j++) {
        long long l = v[it][j] - v[it][i];
        if (s.count((it + l) * 1000000LL + v[it][j]) &&
            s.count((it + l) * 1000000LL + v[it][i]))
          sol++;
        if (it - l >= 0 && v[it - l].size() > rad &&
            s.count((it - l) * 1000000LL + v[it][j]) &&
            s.count((it - l) * 1000000LL + v[it][i]))
          sol++;
      }
  for (long long i = 0; i < mult.size(); i++)
    for (long long j = i + 1; j < mult.size(); j++) {
      long long l = mult[j] - mult[i];
      for (auto it : v[mult[i]])
        if (s.count(mult[i] * 1000000LL + it + l) &&
            s.count(mult[j] * 1000000LL + it) &&
            s.count(mult[j] * 1000000LL + it + l))
          sol++;
    }
  cout << sol;
  return 0;
}
