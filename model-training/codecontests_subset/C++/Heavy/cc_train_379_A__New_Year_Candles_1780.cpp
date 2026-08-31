#include <bits/stdc++.h>
using namespace std;
int naiveSoln(int nCandles, int combineCandles) {
  int result = 0;
  int burning = nCandles, waste = 0;
  while (burning) {
    result += burning;
    int totalWaste = burning + waste;
    burning = totalWaste / combineCandles;
    waste = totalWaste % combineCandles;
  }
  return result;
}
void test() {
  int nCandles[] = {4, 6, 1000, 123};
  int combineCandles[] = {2, 3, 1000, 5};
  int rightAns[] = {7, 8, 1001, 153};
  for (int i = 0; i < 4; i++) {
    int ourAns = naiveSoln(nCandles[i], combineCandles[i]);
    cout << ourAns << endl;
    cout << (ourAns == rightAns[i]) << endl;
  }
}
int main() {
  int nCandles, combineCandles;
  cin >> nCandles >> combineCandles;
  cout << naiveSoln(nCandles, combineCandles) << endl;
  return 0;
}
