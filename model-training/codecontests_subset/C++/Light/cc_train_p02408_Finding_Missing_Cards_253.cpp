#include <iostream>
using namespace std;

int main(){
	bool a[52];
	for (int i = 0; i < 52; i++){
		a[i] = false;
	}
	int n;
	cin >> n;
	char cards[2];
	int cardn;
	for (int i = 0; i < n; i++){
		cin >> cards >> cardn;
		a[(cards[0] == 'S' ? 0 
			: cards[0] == 'H' ? 1 
			: cards[0] == 'C' ? 2 
			: cards[0] == 'D' ? 3 
			: 0) * 13 + cardn - 1] = true;
	}
	for (int i = 0; i < 52; i++){
		if (a[i] == false){
			cout << (i / 13 == 0 ? "S" :
				i / 13 == 1 ? "H" :
				i / 13 == 2 ? "C" :
				i / 13 == 3 ? "D" :
				"S") << " " << i % 13 + 1 << endl;
		}
	}
}