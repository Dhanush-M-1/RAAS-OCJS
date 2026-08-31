#include <bits/stdc++.h>
using namespace std;
int mod = 1000000007;
int n;
short arr[5202][5202];
short check1[5202][5202];
int check(int k) {
  for (int i = 1; i <= n; i += k) {
    for (int j = 1; j <= n; j += k) {
      for (int p = i; p < i + k; p++) {
        for (int q = j; q < j + k; q++) {
          if (arr[i][j] != arr[p][q]) return 0;
        }
      }
    }
  }
  return 1;
}
int32_t main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  cin >> n;
  map<char, string> m;
  m['A'] = "1010";
  m['B'] = "1011";
  m['C'] = "1100";
  m['D'] = "1101";
  m['E'] = "1110";
  m['F'] = "1111";
  m['1'] = "0001";
  m['2'] = "0010";
  m['3'] = "0011";
  m['4'] = "0100";
  m['5'] = "0101";
  m['6'] = "0110";
  m['7'] = "0111";
  m['8'] = "1000";
  m['9'] = "1001";
  m['0'] = "0000";
  string s;
  for (int i = 1; i <= n; i++) {
    cin >> s;
    string val = "";
    for (int i = 0; i < s.length(); i++) val += m[s[i]];
    for (int j = 1; j <= n; j++) arr[i][j] = val[j - 1] - 48;
  }
  vector<int> div;
  for (int i = 1; i <= n; i++) {
    if (n % i == 0) div.push_back(i);
  }
  int high = div.size() - 1;
  int max = 0;
  while (high >= 0) {
    if (check(div[high])) {
      cout << div[high];
      return 0;
    }
    high--;
  }
}
