#include <bits/stdc++.h>
using namespace std;
inline int read() {
  int ret = 0, f = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') f = -f;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') ret = ret * 10 + ch - '0', ch = getchar();
  return ret * f;
}
int main(int argc, char* argv[]) {
  int nNumberCount;
  int nNumberC;
  int nNumberArrays[110];
  int nSumArrays[110];
  int nMaxNumber = INT_MIN;
  cin >> nNumberCount >> nNumberC;
  for (int i = 1; i <= nNumberCount; i++) {
    cin >> nNumberArrays[i];
    nSumArrays[i - 1] = nNumberArrays[i - 1] - nNumberArrays[i];
  }
  for (int i = 1; i < nNumberCount; i++) {
    nMaxNumber = max(nMaxNumber, nSumArrays[i]);
  }
  cout << max(nMaxNumber - nNumberC, 0) << endl;
  return 0;
}
