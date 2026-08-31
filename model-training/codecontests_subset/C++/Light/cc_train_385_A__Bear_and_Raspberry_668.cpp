#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n, c;
  cin >> n >> c;
  long long arr[n];
  for (long long i = 0ll; i < n; i++) {
    cin >> arr[i];
  }
  long long diff = 0;
  for (long long i = 0; i < n - 1; i++) {
    long long rec = arr[i] - arr[i + 1];
    if (rec > diff) {
      diff = rec;
    }
  }
  if (diff - c < 0)
    cout << "0";
  else
    cout << diff - c;
}
