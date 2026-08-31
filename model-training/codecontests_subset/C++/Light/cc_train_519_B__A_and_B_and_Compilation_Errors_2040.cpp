#include <bits/stdc++.h>
using namespace std;
long long int binary_search(long long int ar[], int lb, int ub,
                            long long int data);
int main() {
  long long int n, first, last;
  cin >> n;
  long long int a, b, c, counta = 0, countb = 0, countc = 0;
  for (int i = 0; i < n; i++) {
    cin >> a;
    counta += a;
  }
  for (int i = 0; i < n - 1; i++) {
    cin >> b;
    countb += b;
  }
  for (int i = 0; i < n - 2; i++) {
    cin >> c;
    countc += c;
  }
  first = counta - countb;
  last = countb - countc;
  cout << first << endl << last << endl;
  counta = 0;
  countb = 0;
  countc = 0;
  return 0;
}
