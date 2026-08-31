#include <bits/stdc++.h>
using namespace std;
bool o[5000001];
int prim[5000001];
int que[100001];
int num;
int judge(long long n) {
  int i;
  for (i = 0; i < num; i++) {
    if (n == prim[i]) return 1;
    if (n % prim[i] == 0) {
      return 0;
    }
  }
  return 1;
}
int main() {
  int i, j;
  long long n, ans, temp;
  num = 0;
  for (i = 2; i <= 5000000; i++) {
    if (o[i] == 0) {
      prim[num++] = i;
      for (j = i + i; j <= 5000000; j += i) {
        o[j] = 1;
      }
    }
  }
  cin >> n;
  if (n == 1 || judge(n)) {
    cout << "1\n0\n";
    return 0;
  }
  ans = 1;
  j = 0;
  for (i = 0; i < num; i++) {
    if (n % prim[i] == 0 && judge(n / prim[i])) {
      cout << "2\n";
      return 0;
    }
    temp = n;
    while (temp % prim[i] == 0) {
      temp /= prim[i];
      que[j++] = prim[i];
    }
  }
  cout << "1\n" << que[0] * que[1] << endl;
  return 0;
}
