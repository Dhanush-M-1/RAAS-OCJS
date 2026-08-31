#include <bits/stdc++.h>
using namespace std;

int N;

void BF(string A, char mx) {
  if(A.size() == N) {
    cout << A << "\n";
  }else {
    for(char i = 'a'; i < mx; i++) {
      BF(A + i, mx);
    }
    BF(A + mx, mx + 1);
  }
}

int main() {
  ios_base::sync_with_stdio(0);
  cin >> N;
  BF("", 'a');
}