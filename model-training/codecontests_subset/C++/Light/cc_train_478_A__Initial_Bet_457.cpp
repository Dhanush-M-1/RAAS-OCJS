#include <bits/stdc++.h>
using namespace std;
int main() {
  int a[5], sum = 0;
  for (int i = 0; i < 5 && scanf("%d", &a[i]); i++) sum += a[i];
  cout << (sum % 5 == 0 && sum ? sum / 5 : -1);
}
