#include <iostream>
using namespace std;

int N;
void next(string base, int num, int cs) {
  if (num == N) {
    cout << base << endl;
    return;
  }

  for (int i = 0; i < cs+1; i++) {
    char c = 'a' + i;
    int ncs = cs > i ? cs : i+1;
    next(base + c, num+1, ncs);
  }
}

int main() {
  cin >> N;
  next("", 0, 0);
}