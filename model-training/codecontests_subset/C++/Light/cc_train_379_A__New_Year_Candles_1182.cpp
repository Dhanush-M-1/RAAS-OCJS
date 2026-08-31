#include <bits/stdc++.h>
using namespace std;
void buttons() {
  int n;
  cin >> n;
  int sum = 0, sum2 = 0;
  int x = n;
  for (int i = 1; i < x; i++) {
    sum = (n - 1) * i;
    sum2 += sum;
    n--;
  }
  cout << sum2 + x;
}
int main() {
  int a, b;
  cin >> a >> b;
  int cp = 0;
  while (a > 0) {
    a--;
    cp++;
    if (cp % b == 0) a++;
  }
  cout << cp;
}
