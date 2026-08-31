#include <bits/stdc++.h>
using namespace std;
int main() {
  double citizens = 0;
  double wizards = 0;
  double percentage = 0;
  double clones = 0;
  cin >> citizens >> wizards >> percentage;
  double current = wizards / citizens * 100;
  if (current < percentage) {
    double needed = (percentage - current) / 100;
    clones = citizens * needed;
  }
  cout << (int)(ceil(clones));
}
