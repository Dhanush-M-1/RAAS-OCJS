#include <bits/stdc++.h>
using namespace std;
char aim[1100];
long long a[110];
long long m[110];
long long tran(char str[], int pos) {
  long long ans = 0;
  for (int i = pos; i < strlen(str); i++) {
    ans *= 10;
    ans += str[i] - '0';
  }
  return ans;
}
long long cal(long long a, long long b) {
  if (b < a) return 0;
  return (a + b) * (b - a + 1) / 2;
}
int main() {
  long long add = 0, reduce = 0;
  gets(aim);
  int n;
  for (int i = 0;; i += 4) {
    if (aim[i + 2] == '=') {
      n = tran(aim, i + 4);
      break;
    }
    if (aim[i + 2] == '+')
      add++;
    else
      reduce++;
  }
  if (add + 1 - reduce * n > n || (add + 1LL) * n - reduce < n) {
    cout << "Impossible" << endl;
    return 0;
  } else {
    cout << "Possible" << endl;
    for (int i = 0; i <= add; i++) a[i] = n;
    for (int i = 0; i < reduce; i++) m[i] = 1;
    long long temp = (add + 1LL) * n - reduce - n;
    for (int i = add; i >= 0; i--) {
      if (temp > n - 1) {
        temp -= n - 1;
        a[i] = 1;
      } else {
        a[i] = a[i] - temp;
        temp = 0;
        break;
      }
    }
    if (temp > 0) {
      for (int i = 0; i < reduce; i++) {
        if (temp > n - 1) {
          temp -= n - 1;
          m[i] = n;
        } else {
          m[i] += temp;
          break;
        }
      }
    }
    int tot1 = 1, tot2 = 0;
    printf("%d", a[0]);
    for (int i = 1; i < strlen(aim); i++) {
      if (aim[i] == '?') {
        if (aim[i - 2] == '+')
          printf("%d", a[tot1++]);
        else
          printf("%d", m[tot2++]);
      } else
        printf("%c", aim[i]);
    }
  }
  return 0;
}
