#include <bits/stdc++.h>
using namespace std;
const int maxn = 5000007;
int tot;
long long n, ans;
long long a[maxn];
void work() {
  cin >> n;
  if (n == 1) {
    puts("1");
    puts("0");
    return;
  }
  tot = 0;
  long long i = 2;
  while (i * i <= n) {
    if (n % i == 0) {
      while (n % i == 0) a[++tot] = i, n /= i;
    }
    i++;
  }
  if (n > 1) a[++tot] = n;
  if (tot == 1) {
    puts("1");
    puts("0");
  } else if (tot > 2) {
    puts("1");
    cout << a[1] * a[2] << endl;
  } else
    puts("2");
}
int main() { work(); }
