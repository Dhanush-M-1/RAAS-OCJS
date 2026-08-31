#include <bits/stdc++.h>
using namespace std;
int H, W;
int TH, TW;
string S[404];
string T[404];
bitset<170000> B[26];
bitset<170000> R, R2, mask, lef[401], ri[401];
void solve() {
  int i, j, k, l, r, x, y;
  string s;
  cin >> H >> W;
  for (y = 0; y < (H); y++) {
    cin >> S[y];
    for (x = 0; x < (W); x++) {
      B[S[y][x] - 'a'][y * W + x] = 1;
      R[y * W + x] = 1;
    }
  }
  lef[0] = R2 = R;
  for (x = 1; x <= W; x++) {
    lef[x] = lef[x - 1];
    for (y = 0; y < (H); y++) lef[x][y * W + W - x] = 0;
    ri[x] = (~lef[x]) & R;
  }
  mask = ~R;
  cin >> TH >> TW;
  for (y = 0; y < (TH); y++) {
    cin >> T[y];
    for (x = 0; x < (TW); x++)
      if (T[y][x] != '?') {
        r = T[y][x] - 'a';
        int yy = y % H;
        int xx = x % W;
        bitset<170000> BT =
            ((B[r] >> (yy * W)) | (B[r] << (W * H - (yy * W)))) & R2;
        R &= ((BT >> (xx)) & lef[xx]) | ((BT << (W - xx)) & ri[xx]);
      }
  }
  for (y = 0; y < (H); y++) {
    for (x = 0; x < (W); x++) (void)printf("%d", R[y * W + x] == 1);
    (void)printf("\n");
  }
}
int main(int argc, char** argv) {
  string s;
  int i;
  if (argc == 1) ios::sync_with_stdio(false), cin.tie(0);
  for (i = 0; i < (argc - 1); i++) s += argv[i + 1], s += '\n';
  for (i = 0; i < (s.size()); i++) ungetc(s[s.size() - 1 - i], stdin);
  solve();
  return 0;
}
