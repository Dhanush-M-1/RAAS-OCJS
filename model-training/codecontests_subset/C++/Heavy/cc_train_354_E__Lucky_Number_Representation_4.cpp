#include <bits/stdc++.h>
using namespace std;
const int max_n = 10000, inf = 1e9 + 100;
set<int> bad = {1,  2,   3,   5,   6,   9,   10,  13,  17,  31,  34,
                37, 38,  41,  43,  45,  46,  49,  50,  53,  57,  71,
                83, 111, 123, 391, 403, 437, 457, 471, 483, 511, 523};
bool is_happy(long long a) {
  while (a) {
    int d = a % 10;
    if (d != 4 && d != 0 && d != 7) {
      return false;
    }
    a /= 10;
  }
  return true;
}
vector<int> happy;
bool was2[max_n * 6];
bool was3[max_n * 6];
bool was4[max_n * 6];
bool was5[max_n * 6];
vector<long long> was6[max_n * 6];
int c4[10];
int c7[10];
void init() {
  for (int n4 = 0; n4 <= 6; ++n4) {
    for (int n7 = 0; n7 + n4 <= 6; ++n7) {
      int res = (n4 * 4 + n7 * 7) % 10;
      c4[res] = n4;
      c7[res] = n7;
    }
  }
  for (int i = 0; i < max_n; ++i) {
    if (is_happy(i)) {
      happy.push_back(i);
    }
  }
  reverse(happy.begin(), happy.end());
  int cur = 0;
  for (int a1 : happy) {
    cur += a1;
    for (int a2 : happy) {
      cur += a2;
      if (cur > max_n || was2[cur]) {
        cur -= a2;
        continue;
      }
      was2[cur] = true;
      for (int a3 : happy) {
        cur += a3;
        if (cur > max_n || was3[cur]) {
          cur -= a3;
          continue;
        }
        was3[cur] = true;
        for (int a4 : happy) {
          cur += a4;
          if (cur > max_n || was4[cur]) {
            cur -= a4;
            continue;
          }
          was4[cur] = true;
          for (int a5 : happy) {
            cur += a5;
            if (cur > max_n || was5[cur]) {
              cur -= a5;
              continue;
            }
            was5[cur] = true;
            for (int a6 : happy) {
              cur += a6;
              if (cur > max_n) {
                cur -= a6;
                continue;
              }
              was6[cur] = vector<long long>({a1, a2, a3, a4, a5, a6});
              cur -= a6;
            }
            cur -= a5;
          }
          cur -= a4;
        }
        cur -= a3;
      }
      cur -= a2;
    }
    cur -= a1;
  }
}
vector<long long> solve(long long a) {
  vector<int> ans4;
  vector<int> ans7;
  int per = 0;
  while (a >= max_n) {
    int d = a % 10 - per;
    if (d < 0) d += 10;
    int n4 = c4[d];
    int n7 = c7[d];
    int val = n4 * 4 + n7 * 7 + per;
    ans4.push_back(n4);
    ans7.push_back(n7);
    per = val / 10;
    a /= 10;
  }
  a -= per;
  vector<long long> res = was6[a];
  long long pw = 1;
  for (int i = 0; i < ans4.size(); ++i) {
    pw *= 10;
  }
  for (long long& val : res) {
    val *= pw;
  }
  pw = 1;
  for (int i = 0; i < ans4.size(); ++i) {
    for (int j = 0; j < ans4[i]; ++j) {
      res[j] += 4 * pw;
    }
    for (int j = 0; j < ans7[i]; ++j) {
      res[ans4[i] + j] += 7 * pw;
    }
    pw *= 10;
  }
  return res;
}
int main() {
  init();
  int q;
  cin >> q;
  while (q--) {
    long long a;
    cin >> a;
    if (bad.count(a)) {
      cout << -1 << "\n";
      continue;
    }
    if (a < max_n) {
      for (long long val : was6[a]) {
        cout << val << ' ';
      }
      cout << "\n";
      continue;
    }
    vector<long long> res = solve(a);
    for (long long val : res) {
      cout << val << ' ';
    }
    long long sum = 0;
    for (long long val : res) {
      sum += val;
    }
    if (sum != a) {
      cout << "AAA " << a << endl;
      exit(228);
    }
    cout << "\n";
  }
  return 0;
}
