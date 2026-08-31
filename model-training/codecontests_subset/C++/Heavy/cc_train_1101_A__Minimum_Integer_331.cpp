#include <bits/stdc++.h>
using namespace std;
long long int expo_fast(long long int a, long long int b) {
  a = a;
  long long int result = 1;
  while (b) {
    if (b & 1) result = (result * a);
    b >>= 1;
    a = (a * a);
  }
  return (result);
}
void take_in(vector<long long int>* arr) {
  for (int i = 0; i < arr->size(); i++) cin >> (*(arr))[i];
}
void disp_arr(vector<long long int>* arr) {
  for (int i = 0; i < arr->size(); i++) cout << (*(arr))[i] << " ";
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int q;
  cin >> q;
  while (q--) {
    long long int l, r, d;
    cin >> l >> r >> d;
    if (l > d)
      cout << d << "\n";
    else {
      cout << d * ((r / d) + 1) << "\n";
    }
  }
}
