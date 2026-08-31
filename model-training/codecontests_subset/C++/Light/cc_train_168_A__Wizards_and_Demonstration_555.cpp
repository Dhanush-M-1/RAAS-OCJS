#include <bits/stdc++.h>
using namespace std;
int main() {
  int population, wizards, percent;
  float result;
  int clones = 0;
  cin >> population >> wizards >> percent;
  result = (percent * population) / (float)100;
  while (wizards < result) {
    clones++;
    wizards++;
  }
  cout << clones << endl;
}
