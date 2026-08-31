#include <iostream>
#include <cstdio>
using namespace std;

int main() {
	int n;
	cin >> n;
	bool card[4][13] = {};
	char suit[4] = {'S','H','C','D'};
	for(int i=0; i<n; i++){
		char suit;
		int num;
		cin >> suit >> num;
		if(suit == 'S') card[0][num-1] = 1;
		else if(suit == 'H') card[1][num-1] = 1;
		else if(suit == 'C') card[2][num-1] = 1;
		else if(suit == 'D') card[3][num-1] = 1;
	}
	for(int i=0; i<4; i++){
		for(int j=0; j<13; j++){
			if(!card[i][j]){
				cout << suit[i] << " " << j+1 <<endl;
			}
		}
	}
	return 0;
}
