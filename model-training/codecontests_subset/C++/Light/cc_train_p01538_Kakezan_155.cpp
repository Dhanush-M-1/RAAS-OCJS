#include<iostream>
#include<cmath>
using namespace std;

int next_n(int n) {
  int maximum = -1;
  for (int p = 1; pow(10, p) < n; p++) {
    int base = pow(10, p),
        right = n % base,
        left = (n - right) / base;
    maximum = max(maximum, right * left);
  }
  return maximum;
}

int main() {
  int Q;
  cin >> Q;
  for (int i = 0; i < Q; i++) {
    int N;
    cin >> N;

    int count = 0;
    while (N > 9) {
      N = next_n(N);
      count++;
    }
    cout << count << endl;
  }
}