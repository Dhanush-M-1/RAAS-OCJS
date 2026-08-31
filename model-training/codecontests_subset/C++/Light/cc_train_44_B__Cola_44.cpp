#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, b, c, total;
  long long num_ways;
  num_ways = total = 0;
  cin >> n >> a >> b >> c;
  for (int numb = 0; numb <= b; numb++) {
    for (int numc = 0; numc <= c; numc++) {
      total = numb + 2 * numc;
      if (total == n) num_ways++;
      if (total < n) {
        if (2 * (n - total) <= a) num_ways++;
      }
    }
  }
  cout << num_ways;
}
