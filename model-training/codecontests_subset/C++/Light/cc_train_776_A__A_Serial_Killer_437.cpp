#include <bits/stdc++.h>
using namespace std;
struct Killer {
  string killed;
  string potential;
};
int getType(Killer killer, string val) {
  if (killer.killed == val) {
    return 0;
  }
  if (killer.potential == val) {
    return 1;
  }
  return -1;
}
int main() {
  int count;
  vector<Killer> kill;
  Killer killer;
  cin >> killer.killed;
  cin >> killer.potential;
  cin >> count;
  kill.push_back(killer);
  for (int i = 0; i < count; i++) {
    Killer tmpKiller;
    cin >> tmpKiller.killed;
    cin >> tmpKiller.potential;
    int type = getType(kill[i], tmpKiller.killed);
    if (type == 0) {
      Killer k;
      k.killed = tmpKiller.potential;
      k.potential = kill[i].potential;
      kill.push_back(k);
    } else {
      Killer k;
      k.killed = kill[i].killed;
      k.potential = tmpKiller.potential;
      kill.push_back(k);
    }
  }
  for (int i = 0; i < kill.size(); i++) {
    cout << kill[i].killed << " " << kill[i].potential << endl;
  }
  return 0;
}
