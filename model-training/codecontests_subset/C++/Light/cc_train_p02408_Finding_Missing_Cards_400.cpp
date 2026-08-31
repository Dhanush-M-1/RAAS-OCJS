#include <bits/stdc++.h>
using namespace std;

int card(char c){
	switch(c){
		case 'S':
			return 0;
		case 'H':
			return 1;
		case 'C':
			return 2;
		case 'D':
			return 3;
	}
}

char card2(int i){
	switch(i){
		case 0:
			return 'S';
		case 1:
			return 'H';
		case 2:
			return 'C';
		case 3:
			return 'D';
	}
}

int main(){
	int n,b;
	cin>>n;
	char c;
	bool a[4][13]={};
	for(int i=0;i<n;i++){
		cin>>c>>b;
		a[card(c)][b-1]=1;
	}
	for(int i=0;i<4;i++){
		for(int j=0;j<13;j++){
			if(!a[i][j]){
				cout<<card2(i)<<" "<<j+1<<endl;
			}
		}
	}
	return 0;
}

