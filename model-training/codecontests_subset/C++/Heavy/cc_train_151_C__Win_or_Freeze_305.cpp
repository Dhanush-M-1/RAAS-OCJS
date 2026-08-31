#include <bits/stdc++.h>
using namespace std;
const int N = 100;
long long fac[N];
int cnt[N];
int main() {
  long long a;
  cin >> a;
  if (a == 1) {
    cout << 1 << endl << 0 << endl;
    return 0;
  }
  int num = 0;
  long long i;
  for (i = 2; i * i <= a; i++) {
    if (a % i == 0) {
      int cunt = 0;
      while (a % i == 0) {
        a /= i;
        cunt++;
      }
      fac[num] = i;
      cnt[num++] = cunt;
    }
  }
  if (a > 1) {
    fac[num] = a;
    cnt[num++] = 1;
  }
  int count = 0;
  for (int i = 0; i < num; i++) count += cnt[i];
  if (count == 1) {
    cout << 1 << endl;
    cout << 0 << endl;
  } else if (count == 2) {
    cout << 2 << endl;
  } else {
    long long num = 1;
    int count = 0;
    int j = 0;
    while (count < 2) {
      for (int i = 0; count < 2 && i < cnt[j]; i++) {
        num *= fac[j];
        count++;
      }
      j++;
    }
    cout << 1 << endl;
    cout << num << endl;
  }
}
