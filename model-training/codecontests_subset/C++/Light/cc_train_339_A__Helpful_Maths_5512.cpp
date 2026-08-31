#include <bits/stdc++.h>
using namespace std;
int main() {
  string input;
  cin >> input;
  int A[100];
  int x = 0;
  for (int i = 0; i < input.length(); i++) {
    if (input[i] != '+') {
      A[x] = input[i] - 48;
      x++;
    }
  }
  sort(A, A + x);
  cout << A[0];
  for (int i = 1; i < x; i++) {
    cout << "+" << A[i];
  }
  cout << endl;
}
