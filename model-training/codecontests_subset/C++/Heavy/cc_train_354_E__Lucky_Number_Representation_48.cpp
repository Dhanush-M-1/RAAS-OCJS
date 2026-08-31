#include <bits/stdc++.h>
using namespace std;
const long long BASE[28] = {0,  4,  7,  8,  11, 12, 14, 15, 16, 18,
                            19, 20, 21, 22, 23, 24, 25, 26, 27, 28,
                            29, 30, 32, 33, 35, 36, 39, 42};
int TBL[28][2];
const long long DAME1[33] = {
    +1,  +2,   +3,   +5,   +6,   +9,   +10,  +13,  +17,  +31,  +34,
    +37, +38,  +41,  +43,  +45,  +46,  +49,  +50,  +53,  +57,  +71,
    +83, +111, +123, +391, +403, +437, +457, +471, +483, +511, +523};
const long long DAME2[14] = {-71, -62, -59, -55, -41, -32, -29,
                             -25, -11, -8,  -5,  -4,  -2,  -1};
long long ONEMAX[1 + 18];
long long SIXMAX[1 + 18];
bool YES1[1 + 42];
bool YES2[1 + 462];
bool YES(int N, long long X) {
  if (X < 0 || X > SIXMAX[N]) return false;
  if (N == 0) return true;
  if (N == 1) return YES1[X];
  if (N == 2) return YES2[X];
  const long long *it;
  it = lower_bound(DAME1, DAME1 + 33, X);
  if (it != DAME1 + 33 && *it == X) return false;
  it = lower_bound(DAME2, DAME2 + 14, X - SIXMAX[N]);
  if (it != DAME2 + 14 && *it == X - SIXMAX[N]) return false;
  return true;
}
bool solve(long long X) {
  int A[18];
  long long Z[6];
  if (!YES(18, X)) return false;
  for (int i = 0; i < 18; i++) {
    for (int j = 0; j < 28; j++) {
      long long Y = X - BASE[j];
      if (Y < 0 || Y % 10 != 0) continue;
      Y /= 10;
      if (!YES(17 - i, Y)) continue;
      X = Y;
      A[i] = j;
      break;
    }
  }
  memset(Z, 0x00, sizeof(Z));
  for (int i = 17; i >= 0; i--) {
    int n4 = TBL[A[i]][0];
    int n7 = TBL[A[i]][1];
    for (int j = 0; j < 6; j++) {
      Z[j] *= 10;
      if (n4 != 0) {
        Z[j] += 4;
        n4--;
      } else if (n7 != 0) {
        Z[j] += 7;
        n7--;
      }
    }
  }
  cout << Z[0] << ' ' << Z[1] << ' ' << Z[2] << ' ' << Z[3] << ' ' << Z[4]
       << ' ' << Z[5] << endl;
  return true;
}
void build() {
  for (int i = 0; i < 28; i++) {
    for (int j = 0; j <= 6; j++) {
      for (int k = 0; j + k <= 6; k++) {
        if (j * 4 + k * 7 == BASE[i]) {
          TBL[i][0] = j;
          TBL[i][1] = k;
          goto out;
        }
      }
    }
  out:;
  }
  for (int i = 1; i <= 18; i++) {
    ONEMAX[i] = ONEMAX[i - 1] * 10 + 7;
    SIXMAX[i] = 6 * ONEMAX[i];
  }
  for (int i = 0; i < 28; i++) {
    YES1[BASE[i]] = true;
    for (int j = 0; j < 28; j++) YES2[BASE[i] * 10 + BASE[j]] = true;
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  build();
  int T;
  cin >> T;
  while (--T >= 0) {
    long long X;
    cin >> X;
    if (!solve(X)) cout << "-1" << endl;
  }
  return 0;
}
