#include <bits/stdc++.h>
using namespace std;
static const double EPS = 1e-8;
int main() {
  istream &fin = cin;
  ostream &fout = cout;
  FILE *fpin = stdin;
  FILE *fpout = stdout;
  int A, B, C;
  fin >> A >> B >> C;
  if (A == 0 && B == 0 && C == 0) {
    fout << -1 << endl;
    return 0;
  }
  if (A == 0) {
    if (B == 0) {
      fout << 0 << endl;
      return 0;
    }
    fout << 1 << endl;
    fout << fixed << setprecision(15) << (double)(-C) / B << endl;
    return 0;
  }
  long long D = (long long)B * B - 4LL * A * C;
  if (D < 0) {
    fout << 0 << endl;
    return 0;
  }
  if (D == 0) {
    fout << 1 << endl;
    fout << fixed << setprecision(15) << (double)(-B) / (2. * A) << endl;
    return 0;
  }
  fout << 2 << endl;
  double res1 = ((double)(-B) + sqrt((double)D)) / (2. * A);
  double res2 = ((double)(-B) - sqrt((double)D)) / (2. * A);
  if (res1 > res2) swap(res1, res2);
  fout << fixed << setprecision(15) << res1 << endl;
  fout << fixed << setprecision(15) << res2 << endl;
}
