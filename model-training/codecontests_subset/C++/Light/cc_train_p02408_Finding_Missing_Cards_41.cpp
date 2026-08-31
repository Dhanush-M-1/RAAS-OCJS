#include <iostream>
#include <string>
using namespace std;


static const string mark[4] = {"S", "H", "C", "D"};

int main(void) {

	int n;
	cin >> n;

	int card[4][13] = {};
	string a;
	int b;
	for(int i=0;i<n;i++) {
		cin >> a >> b;
		if(a == "S")		card[0][b-1] = 1;
		else if(a == "H")	card[1][b-1] = 1;
		else if(a == "C")	card[2][b-1] = 1;
		else if(a == "D")	card[3][b-1] = 1;
	}

	for(int i=0;i<4;i++) {
		for(int j=0;j<13;j++) {
			if(card[i][j] == 0) {
				cout << mark[i] << " " << j+1 << endl;
			}
		}
	}

	return 0;
}