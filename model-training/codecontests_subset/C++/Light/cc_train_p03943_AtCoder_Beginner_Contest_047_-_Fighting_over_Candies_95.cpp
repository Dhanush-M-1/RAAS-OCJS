#include <bits/stdc++.h>
using namespace std;

int main() {
  int A, B, C;
  cin >> A >> B >> C;

  cout << ((A == B + C || B == A + C || C == A + B) ? "Yes" : "No") << endl;
}