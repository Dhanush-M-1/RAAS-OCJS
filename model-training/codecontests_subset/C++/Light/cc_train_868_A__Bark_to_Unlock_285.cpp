#include <bits/stdc++.h>
using namespace std;
const long long MX = 0;
const long long MN = 0;
long long mx = MX, mn = MN;
long long x, c, k, n, m, cnt, y, ans;
string s, str;
bool bl;
vector<string> v, vc;
map<char, long long> mp;
set<long long> st;
set<long long>::iterator it;
vector<long long> g[1001];
bool used[1001];
long long ar1[1001], ar2[1001];
pair<long long, long long> pr[1001];
char arc[101][101];
string r[5 + 1] = {"S", "M", "L", "XL", "XXL"};
void dfs(long long v) {
  used[v] = 1;
  for (long long i = 0; i < g[v].size(); i++) {
    long long to = g[v][i];
    if (!used[to]) {
      cnt++;
      dfs(to);
    }
  }
}
int main() {
  cin >> s >> x;
  for (long long i = 0; i < x; i++) {
    cin >> str;
    v.push_back(str);
  }
  for (long long i = 0; i < v.size(); i++) {
    for (long long j = 0; j < v.size(); j++) {
      if (i == j) {
        str = v[i];
        if ((s[0] == str[0] and s[1] == str[1]) or
            (s[0] == str[1] and s[1] == str[0])) {
          cout << "YES";
          return 0;
        }
      } else {
        str = v[i] + v[j];
        for (long long h = 0; h < str.size(); h++) {
          if (str[h] == s[0] and str[h + 1] == s[1]) {
            cout << "YES";
            return 0;
          }
        }
      }
    }
  }
  cout << "NO";
  return 0;
}
