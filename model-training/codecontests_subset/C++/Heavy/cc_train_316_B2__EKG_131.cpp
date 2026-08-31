#include <bits/stdc++.h>
struct Patient {
  unsigned int previous;
  unsigned int next;
  unsigned int group;
  Patient() {
    previous = 0;
    next = 0;
    group = 0;
  }
};
unsigned int patientCount;
unsigned int smartBeaver;
Patient patients[1001];
unsigned int groupSizes[1001] = {0};
unsigned int groupCount = 0;
void readInput() {
  std::cin >> patientCount >> smartBeaver;
  for (unsigned int i = 1; i <= patientCount; i++) {
    unsigned int next;
    std::cin >> next;
    if (next != 0) {
      patients[i].next = next;
      patients[next].previous = i;
    }
  }
}
void goGroup(unsigned int i, unsigned int group) {
  if (i == 0) return;
  if (patients[i].group != 0) return;
  groupSizes[group]++;
  patients[i].group = group;
  goGroup(patients[i].previous, group);
  goGroup(patients[i].next, group);
}
unsigned int getBeaverGroupPos(unsigned int i) {
  if (patients[i].next == 0)
    return 1;
  else
    return getBeaverGroupPos(patients[i].next) + 1;
}
std::set<unsigned int> sums;
unsigned int beenHere[1001];
void generateSums(unsigned int i, unsigned int sum) {
  if (beenHere[sum] <= i) return;
  if (i == groupCount) {
    sums.insert(sum);
    return;
  }
  generateSums(i + 1, sum);
  beenHere[sum] = i;
  generateSums(i + 1, sum + groupSizes[i]);
}
void solve() {
  for (unsigned int i = 1; i <= patientCount; i++) {
    if (patients[i].group == 0) {
      goGroup(i, ++groupCount);
    }
  }
  unsigned int smartBeaverGroupPos = getBeaverGroupPos(smartBeaver);
  std::swap(groupSizes[patients[smartBeaver].group], groupSizes[groupCount]);
  std::random_shuffle(groupSizes + 1, groupSizes + groupCount);
  for (unsigned int i = 0; i <= 1000; i++) {
    beenHere[i] = UINT_MAX;
  }
  generateSums(1, smartBeaverGroupPos);
  for (unsigned int sum : sums) {
    std::cout << sum << std::endl;
  }
}
int main() {
  readInput();
  solve();
  return 0;
}
