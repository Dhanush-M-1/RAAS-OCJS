#include <bits/stdc++.h>
using namespace std;
const int MAX_BUF_SIZE = 16384;
char BUFOR[MAX_BUF_SIZE];
int BUF_SIZE, BUF_POS;
char ZZZ;
const int MXN = 1000010;
const int INF = 1000000001;
int n, m;
pair<int, int> A, B, C, D, X;
void test() {
  cin >> A.first >> A.second >> B.first >> B.second >> C.first >> C.second;
  pair<int, int> obr = A;
  int dec = 0;
  for (int i = 0; i < 4; i++) {
    if (A == B) dec = 1;
    int Ax = A.first;
    int Ay = A.second;
    A.first = -Ay;
    A.second = Ax;
  }
  A = obr;
  for (int j = 0; j < 4; j++) {
    X.first = B.first - A.first;
    X.second = B.second - A.second;
    D.first = -C.second;
    D.second = C.first;
    pair<int, int> ZERO;
    ZERO.first = 0;
    ZERO.second = 0;
    long long int det =
        (long long int)C.first * D.second - (long long int)C.second * D.first;
    if (det != 0) {
      if (det < 0) det = -det;
      long long int det2 =
          (long long int)X.first * D.second - (long long int)X.second * D.first;
      long long int det3 =
          (long long int)C.first * X.second - (long long int)C.second * X.first;
      if (det2 < 0) det2 = -det2;
      if (det3 < 0) det3 = -det3;
      if (det2 % det == 0 && det3 % det == 0) dec = 1;
    }
    pair<int, int> E = A;
    A.first = -E.second;
    A.second = E.first;
  }
  if (dec)
    printf("YES\n");
  else
    printf("NO\n");
}
int main() {
  int te = 1;
  while (te--) test();
  return 0;
}
