#include <bits/stdc++.h>
using namespace std;
int main(int argc, const char* argv[]) {
  ios::sync_with_stdio(true);
  set<int> s;
  set<int> s2;
  set<int>::iterator it;
  int n, aux = 0, error1 = 0, error2 = 0;
  long int sum = 0, prevSum = 0, c = 0, aux2, iter;
  cin >> n;
  iter = n - 2;
  while (n >= iter) {
    n--;
    for (int i = 1; i <= (n + 1); i++) {
      cin >> aux;
      sum = sum + aux;
    }
    if (c == 0) {
      prevSum = sum;
    } else {
      aux2 = prevSum - sum;
      cout << aux2 << endl;
      prevSum = sum;
    }
    sum = 0;
    c++;
  }
  return 0;
}
