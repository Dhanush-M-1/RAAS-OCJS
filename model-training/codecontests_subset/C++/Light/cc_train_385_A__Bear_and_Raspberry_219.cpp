#include <bits/stdc++.h>
using namespace std;
int main() {
  int Ndays, discount;
  cin >> Ndays >> discount;
  int arrdays[100];
  int arrsub[100] = {0};
  for (int i = 0; i < Ndays; i++) {
    cin >> arrdays[i];
  }
  for (int i = 0; i < Ndays - 1; i++) {
    arrsub[i] = arrdays[i] - arrdays[i + 1];
  }
  int max = 0;
  for (int i = 0; i < Ndays - 1; i++) {
    if (max < arrsub[i]) max = arrsub[i];
  }
  if (max > discount)
    cout << max - discount;
  else
    cout << 0;
  return 0;
}
