#include <bits/stdc++.h>
int arra[10001];
int arrb[10001];
int arrc[10001];
int boo[10001];
bool binsearch(int a, int n, int* arr) {
  int l = 0;
  int r = n + 1;
  int mid;
  while (l < r - 1) {
    mid = (l + r) / 2;
    if (arr[mid] == a) {
      if (boo[mid] == true)
        return false;
      else {
        boo[mid] = true;
        return true;
      }
    } else if (arr[mid] > a)
      r = mid;
    else
      l = mid;
  }
  if (arr[l] == a && boo[l] != true) {
    boo[l] = true;
    return true;
  } else
    return false;
}
int main() {
  using namespace std;
  int n;
  long long sum1 = 0, sum2 = 0, sum3 = 0;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    int a;
    cin >> a;
    sum1 += a;
  }
  for (int i = 1; i < n; i++) {
    int a;
    cin >> a;
    sum2 += a;
  }
  for (int i = 1; i < n - 1; i++) {
    int a;
    cin >> a;
    sum3 += a;
  }
  cout << sum1 - sum2 << endl << sum2 - sum3;
}
