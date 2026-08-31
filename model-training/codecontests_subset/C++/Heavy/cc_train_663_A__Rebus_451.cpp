#include <bits/stdc++.h>
using namespace std;
char a[1005];
int main() {
  char ch;
  int k = 0, n, pos = 1, neg = 0;
  while (1) {
    scanf(" %c", &ch);
    scanf(" %c", &ch);
    if (ch == '=') break;
    if (ch == '-') neg++;
    if (ch == '+') pos++;
    a[k++] = ch;
  }
  scanf("%d", &n);
  if (n < (pos - n * neg) || n > (n * pos - neg)) {
    cout << "Impossible\n";
    return 0;
  }
  cout << "Possible\n";
  int sum = 0;
  for (int i = 0; i < k; i++) {
    int sign = 1;
    if (i > 0 && a[i - 1] == '-') sign = -1;
    if (sign == 1)
      pos--;
    else
      neg--;
    for (int x = 1; x <= n; x++) {
      if ((sum + sign * x + pos - n * neg <= n) &&
          (sum + sign * x + n * pos - neg) >= n) {
        cout << x << " " << a[i] << " ";
        sum += x * sign;
        break;
      }
    }
  }
  cout << abs(sum - n) << " = " << n;
}
