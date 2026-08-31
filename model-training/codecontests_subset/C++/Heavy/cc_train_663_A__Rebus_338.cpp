#include <bits/stdc++.h>
using namespace std;
long long power(long long a, long long b) {
  long long ans = 1;
  while (b > 0) {
    if (b % 2 != 0) {
      ans = (ans * a) % 1000000007;
    }
    a = (a * a) % 1000000007;
    b >>= 1;
  }
  return ans;
}
int main() {
  std::ios::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  int t = 1;
  while (t--) {
    vector<string> s;
    string h;
    while (cin >> h) {
      s.push_back(h);
    }
    int z = stoi(s[s.size() - 1]);
    if (s.size() == 3) {
      cout << "Possible" << endl << z << " = " << z;
      return 0;
    }
    int n = 0, m = 0;
    for (int i = 0; i < s.size(); i++) {
      if (s[i] == "+") n++;
      if (s[i] == "-") m++;
    }
    n++;
    int p, q;
    int o = -1;
    for (q = 1; q <= z; q++) {
      p = ceil((z + m * q) / double(n));
      int hap = (z + m * q) / n;
      if (hap == 0) continue;
      if (p >= 1 && p <= z) {
        o = q;
        break;
      }
    }
    if (o == -1) {
      cout << "Impossible";
      return 0;
    } else
      cout << "Possible" << endl;
    q = o;
    o = z + m * q;
    p = ceil(o / double(n));
    int cnt = o % (n);
    vector<string> v;
    v.push_back(to_string(p));
    cnt--;
    for (int i = 1; i < s.size(); i++) {
      if (s[i] != "?") {
        v.push_back(s[i]);
        continue;
      }
      if (v[v.size() - 1] == "-") {
        v.push_back(to_string(q));
        continue;
      }
      if (cnt == 0) {
        v.push_back(to_string(p - 1));
      } else {
        v.push_back(to_string(p));
        cnt--;
      }
    }
    for (auto i : v) cout << i << " ";
  }
  return 0;
}
