#include <bits/stdc++.h>
using namespace std;
int Z;
string N;
vector<pair<int, int> > vf;
bool f[20][5];
pair<int, int> p[20][5];
string sres[6];
void prep();
void solve();
void back_track(int, int);
int main() {
  prep();
  cin >> Z;
  for (int zi = 1; zi <= Z; ++zi) cin >> N, solve();
  return 0;
}
void prep() {
  for (int i = 0; i <= 6; ++i)
    for (int j = 0; i + j <= 6; ++j) vf.push_back(make_pair(i, j));
}
void solve() {
  fill(&f[0][0], &f[20][0], false);
  f[0][0] = true;
  reverse((N).begin(), (N).end());
  for (int i = 0; i < int((N).size()); ++i)
    for (int j = 0; j < 5; ++j)
      if (f[i][j]) {
        int t = int(N[i] - '0');
        for (int k = 0; k < int((vf).size()); ++k) {
          int r = j + 4 * vf[k].first + 7 * vf[k].second;
          if (r % 10 == t) {
            f[i + 1][r / 10] = true;
            p[i + 1][r / 10] = make_pair(j, k);
          }
        }
      }
  if (!f[int((N).size())][0])
    cout << "-1\n";
  else {
    for (int i = 0; i < 6; ++i) sres[i] = "";
    back_track(int((N).size()), 0);
    for (int i = 0; i < 6; ++i) {
      istringstream iss(sres[i]);
      long long res;
      iss >> res;
      cout << res << (i + 1 == 6 ? "\n" : " ");
    }
  }
}
void back_track(int i, int j) {
  if (i > 0) {
    int k = 0, s = vf[p[i][j].second].first, t = vf[p[i][j].second].second;
    for (int c = 0; c < s; ++c, ++k) sres[k].push_back('4');
    for (int c = 0; c < t; ++c, ++k) sres[k].push_back('7');
    while (k < 6) sres[k].push_back('0'), ++k;
    back_track(i - 1, p[i][j].first);
  }
}
