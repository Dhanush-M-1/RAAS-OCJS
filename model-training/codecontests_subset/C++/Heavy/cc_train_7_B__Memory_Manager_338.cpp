#include <bits/stdc++.h>
using namespace std;
const double EPS = 1E-10;
inline long long intpow(long long a, long long n) {
  long long r = 1;
  while (n) {
    if (n & 1) {
      r *= a;
    } else {
      a *= a;
      n = n >> 1;
    }
  }
  return r;
}
inline long long hash(string s) {
  long long r = 0;
  long long p = 1;
  long long m = 1777;
  for (int i = 0; i < s.size(); i++) {
    r += s[i] * p;
    p *= m;
  }
  return r;
}
inline short bit(long long a, int p) { return (a >> p) & 1; }
inline long long gcd(long long a, long long b) {
  if (a == b) return a;
  if (a == 0) return b;
  if (b == 0) return a;
  if (a > b)
    return gcd(a % b, b);
  else
    return gcd(a, b % a);
}
vector<string> splitstring(string s, char* tokens) {
  bool b[256];
  memset(b, 0, sizeof(b));
  for (int i = 0; i < strlen(tokens); i++) {
    b[int(tokens[i])] = true;
  }
  vector<string> r;
  string t = "";
  for (int i = 0; i < s.size(); i++) {
    if (b[s[i]]) {
      if (!t.empty()) {
        r.push_back(t);
        t.clear();
      }
    } else {
      t += s[i];
    }
  }
  if (!t.empty()) {
    r.push_back(t);
    t.clear();
  }
  return r;
}
vector<int> kmp(string s, string t) {
  string r = s + "\r" + t;
  int sz = r.size();
  int ssz = s.size();
  int tsz = t.size();
  vector<int> p(sz);
  p[0] = 0;
  int j;
  for (int i = 1; i < sz; ++i) {
    j = p[i - 1];
    while (j > 0 && r[i] != r[j]) j = p[j - 1];
    if (r[i] == r[j]) ++j;
    p[i] = j;
  }
  vector<int> ans;
  for (int i = s.size() + 1; i < sz; i++) {
    if (p[i] == ssz) {
      ans.push_back(i - ssz - ssz);
    }
  }
  return ans;
}
void dbgVint(vector<int> a) {
  for (int i = 0; i < a.size(); i++) {
    printf("%d ", a[i]);
  }
  printf("\n");
}
void dbgVvint(vector<vector<int> > a) {
  for (int i = 0; i < a.size(); i++) {
    dbgVint(a[i]);
  }
}
void dbgVstr(vector<string> a) {
  for (int i = 0; i < a.size(); i++) {
    printf("%s\n", a[i].data());
  }
}
int main() {
  int t, m;
  cin >> t >> m;
  vector<int> b(m);
  int id = 1;
  for (int i = 0; i < t; i++) {
    string s;
    cin >> s;
    if (s[0] == 'a') {
      int sz;
      cin >> sz;
      bool p = false;
      int k = 0;
      for (int j = 0; j < m; j++) {
        if (b[j] == 0)
          k++;
        else {
          k = 0;
        }
        if (k == sz) {
          for (int u = j - k + 1; u <= j; u++) {
            b[u] = id;
          }
          p = true;
          break;
        }
      }
      if (p) {
        cout << id << endl;
        id++;
      } else {
        cout << "NULL" << endl;
      }
    } else {
      if (s[0] == 'e') {
        int w;
        cin >> w;
        if (w >= id || w <= 0) {
          cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
          continue;
        }
        bool p = false;
        for (int i = 0; i < m; i++) {
          if (b[i] == w) {
            p = true;
            for (int j = i; j < m && b[j] == w; j++) {
              b[j] = 0;
            }
            break;
          }
        }
        if (!p) {
          cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
        }
      } else {
        vector<int> nb;
        for (int i = 0; i < m; i++) {
          if (b[i] != 0) nb.push_back(b[i]);
        }
        nb.resize(m);
        b = nb;
      }
    }
  }
  return 0;
}
