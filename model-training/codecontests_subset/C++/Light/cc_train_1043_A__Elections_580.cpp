#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n, sum = 0, sum1 = 0;
  cin >> n;
  vector<int> mas(n);
  for (int i = 0; i < n; i++) {
    cin >> mas[i];
    sum += mas[i];
  }
  int max = *max_element(mas.begin(), mas.end());
  while (sum1 <= sum) {
    sum1 = 0;
    for (int i = 0; i < n; i++) {
      sum1 += max - mas[i];
    }
    max++;
  }
  cout << max - 1;
  return 0;
}
