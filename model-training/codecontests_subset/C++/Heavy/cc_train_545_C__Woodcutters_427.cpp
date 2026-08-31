#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, i, count1, l_b, count2;
  cin >> n;
  long long p[n], h[n];
  for (i = 0; i < n; i++) {
    cin >> p[i] >> h[i];
  }
  count1 = 1;
  l_b = p[0];
  for (i = 1; i < n - 1; i++) {
    if (l_b < p[i] - h[i]) {
      count1++;
      l_b = p[i];
    } else if (p[i + 1] > p[i] + h[i]) {
      count1++;
      l_b = p[i] + h[i];
    } else {
      l_b = p[i];
    }
  }
  count2 = 1;
  l_b = p[n - 1];
  for (i = n - 2; i > 0; i--) {
    if (l_b > p[i] + h[i]) {
      count2++;
      l_b = p[i];
    } else if (p[i - 1] < p[i] - h[i]) {
      count2++;
      l_b = p[i] - h[i];
    } else {
      l_b = p[i];
    }
  }
  if (n > 2) {
    cout << max(count1 + 1, count2 + 1);
  } else {
    cout << n;
  }
  return 0;
}
