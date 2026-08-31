#include <stdio.h>
#include <iostream>

using namespace std;

int main(){
	char suit[4] = {'S', 'H', 'C', 'D'};
	int card[4][13];
	for(int i = 0; i < 4; i++){
		for (int j = 0; j < 13; j++){
			card[i][j] = 1;
		}
	}
	int n;
	cin >> n;
	for(int i = 0; i < n; i++){
		char s;
		int c;
		cin >> s >> c;
		int snumber;
		for(int j = 0; j < 4; j++){
			if(s == suit[j]){
				snumber = j;
			}
		}
		card[snumber][c-1] = 0;
	}
	for(int i = 0; i < 4; i++){
		for(int j = 0; j < 13; j++){
			if(card[i][j]==1){
				cout << suit[i] << " " << j+1 << "\n";
			}
		}
	}
}
