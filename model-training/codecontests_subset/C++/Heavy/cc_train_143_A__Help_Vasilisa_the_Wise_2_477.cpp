#include <bits/stdc++.h>
using namespace std;
long long tt, a1, a2 = 1000000000000, a3, a4, a5, a6, a7, a8, a9, ez1, ans, n,
                  m, k, sum;
int ul, ur, dl, dr;
string s, s1, s2, s3;
int flag[30];
bool omm(const pair<int, int> &a, const pair<int, int> &b) {
  return (a.second < b.second);
}
void input() {
  cin >> a1 >> a2;
  cin >> a3 >> a4;
  cin >> a5 >> a6;
}
void solve() {
  for (int i = 1; i < 10; i++)
    for (int j = 1; j < 10; j++)
      for (int k = 1; k < 10; k++)
        for (int l = 1; l < 10; l++)
          if (i + j == a1 && i + k == a3 && i + l == a5 && j + l == a4 &&
              j + k == a6 && l + k == a2 && i != j && i != k && i != l &&
              j != k && j != l && l != k) {
            cout << i << ' ' << j << endl << k << ' ' << l << endl;
            return;
          }
  cout << -1 << endl;
}
int main() {
  ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  input();
  solve();
  return 0;
}
