#include <iostream>

using std::cin;
using std::cout;

bool cards[26][14];

int main() {
	int n;
	cin >> n;
	for(int i = 1; i <= n; i++) {
		char s; int r;
		cin >> s >> r;
		cards[s - 'A'][r] = 1;
	}
	for(int i = 1; i <= 13; i++) if(!cards['S' - 'A'][i]) cout << "S " << i << '\n';
	for(int i = 1; i <= 13; i++) if(!cards['H' - 'A'][i]) cout << "H " << i << '\n';
	for(int i = 1; i <= 13; i++) if(!cards['C' - 'A'][i]) cout << "C " << i << '\n';
	for(int i = 1; i <= 13; i++) if(!cards['D' - 'A'][i]) cout << "D " << i << '\n';
	return 0;
}
