#include <bits/stdc++.h>
using namespace std;
int day[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
struct edge {
  int to, cost;
};
bool isupper(char c) {
  if ('A' <= c && c <= 'Z') return 1;
  return 0;
}
bool islower(char c) {
  if ('a' <= c && c <= 'z') return 1;
  return 0;
}
bool isPrime(int x) {
  if (x == 1) return 0;
  if (x == 2) return 1;
  if (x % 2 == 0) return 0;
  for (int i = 3; i * i <= x; i++)
    if (x % i == 0) return 0;
  return 1;
}
bool iskaibun(string s) {
  for (int i = 0; i < s.size() / 2; i++)
    if (s[i] != s[s.size() - i - 1]) return 0;
  return 1;
}
bool isnumber(char c) { return ('0' <= c && c <= '9'); }
bool isalpha(char c) { return (isupper(c) || islower(c)); }
void printvi(vector<int> v) {
  for (int i = (int)0; i < (int)v.size(); i++) {
    if (i) cout << " ";
    cout << v[i];
  }
  cout << endl;
}
void printvil(vector<int> v) {
  for (int i = (int)0; i < (int)v.size(); i++) {
    cout << v[i] << endl;
  }
}
void printvvi(vector<vector<int>> v) {
  for (int i = (int)0; i < (int)v.size(); i++) {
    for (int j = (int)0; j < (int)v[i].size(); j++) {
      if (j) cout << " ";
      cout << v[i][j];
    }
    cout << endl;
  }
}
void printvstr(vector<string> v) {
  for (int i = (int)0; i < (int)v.size(); i++) {
    cout << v[i] << endl;
  }
}
int gcd(int a, int b) {
  if (b == 0)
    return a;
  else
    return gcd(b, a % b);
}
struct S {
  int idx, value;
};
signed main() {
  int n;
  cin >> n;
  string s;
  cin >> s;
  int v[20] = {0};
  for (int i = (int)0; i < (int)n; i++) {
    v[s[i] - '0']++;
  }
  int ans = v[8];
  int anss = 0;
  for (int i = (int)1; i < (int)ans + 1; i++) {
    if ((n - i) / 10 >= i) anss = i;
  }
  cout << anss << endl;
}
