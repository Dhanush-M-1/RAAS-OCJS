#include <bits/stdc++.h>
using namespace std;
int positives, negatives;
string qmark, op;
int goal;
vector<int> positive;
vector<int> negative;
string stuff[101];
long long int diff;
int n;
void subtractpositives() {
  for (int i = 0; i < positive.size(); i++) {
    if (diff >= n - 1) {
      positive[i] = 1;
      diff -= (n - 1);
    } else if (diff > 0) {
      positive[i] -= diff;
      diff = 0;
    }
  }
}
void addnegatives() {
  for (int i = 0; i < negative.size(); i++) {
    if (diff >= n - 1) {
      negative[i] = n;
      diff -= (n - 1);
    } else if (diff > 0) {
      negative[i] += diff;
      diff = 0;
    }
  }
}
int main() {
  int cnter = 0;
  positives = 1;
  cin >> qmark;
  while (cin >> op >> qmark) {
    if (op == "=") break;
    if (op == "+")
      positives++;
    else
      negatives++;
    stuff[cnter] = op;
    cnter++;
  }
  goal = stoi(qmark);
  n = goal;
  if (goal > positives * goal - negatives ||
      goal < (-negatives * goal) + positives)
    cout << "Impossible" << endl;
  else {
    cout << "Possible" << endl;
    long long int sum = n * positives - negatives;
    for (int i = 0; i < positives; i++) {
      positive.push_back(n);
    }
    for (int i = 0; i < negatives; i++) {
      negative.push_back(1);
    }
    diff = sum - goal;
    subtractpositives();
    addnegatives();
    int curpositive = 1;
    int curnegative = 0;
    cout << positive[0] << " ";
    for (int i = 0; i < cnter; i++) {
      if (stuff[i] == "-") {
        cout << "- " << negative[curnegative] << ' ';
        curnegative++;
      }
      if (stuff[i] == "+") {
        cout << "+ " << positive[curpositive] << ' ';
        curpositive++;
      }
    }
    cout << "= " << goal << '\n';
  }
}
