#include <bits/stdc++.h>
using namespace std;
bool prime[100000 + 1];
void sieve() {
  memset(prime, true, sizeof(prime));
  for (long p = 2; p * p <= 100000; p++) {
    if (prime[p] == true) {
      for (long i = p * p; i <= 100000; i += p) prime[i] = false;
    }
  }
}
long long gcd(long long a, long long b) {
  if (a == 0) return b;
  return gcd(b % a, a);
}
long power(int v, int a) {
  long prod = 1;
  for (int i = 0; i < a; i++) prod *= v;
  return prod;
}
int countFreq(string &pat, string &txt) {
  int M = pat.length();
  int N = txt.length();
  int res = 0;
  for (int i = 0; i <= N - M; i++) {
    int j;
    for (j = 0; j < M; j++)
      if (txt[i + j] != pat[j]) break;
    if (j == M) {
      res++;
      j = 0;
    }
  }
  return res;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int T = 1;
  while (T--) {
    string s;
    vector<string> v;
    int d[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    for (int i = 2013; i <= 2015; i++) {
      for (int j = 1; j <= 12; j++) {
        for (int k = 1; k <= d[j - 1]; k++) {
          string temp = "";
          if (k / 10 == 0) temp += "0";
          temp += to_string(k) + "-";
          if (j / 10 == 0) temp += "0";
          temp += to_string(j) + "-";
          temp += to_string(i);
          v.push_back(temp);
        }
      }
    }
    cin >> s;
    int ans = 0;
    string final;
    for (int i = 0; i < v.size(); i++) {
      int t = countFreq(v[i], s);
      if (ans < t) {
        ans = t;
        final = v[i];
      }
    }
    cout << final;
  }
  cerr << "Time elapsed: " << 1.0 * clock() / CLOCKS_PER_SEC << " s.\n";
  return 0;
}
