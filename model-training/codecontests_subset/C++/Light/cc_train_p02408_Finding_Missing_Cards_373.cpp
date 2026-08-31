#include<iostream>
using namespace std;
int main(){
	char x,ch;
	int n,y,i,S,H,C,D,j,p;
	bool cards[4][13]={false};
	cin>>n;
	for(i=0;i<n;i++){
	cin>>x>>y;
	if(x=='S'){
		cards[0][y-1]=true;
	}
	else if(x=='H'){
	cards[1][y-1]=true;
	}
	else if(x=='C'){
		cards[2][y-1]=true;
	}
	else if(x=='D'){
		cards[3][y-1]=true;
	}
	}
	for(j=0;j<4;j++){
		for(p=0;p<13;p++){
		if(cards[j][p]==false){
			switch (j){
			case 0: ch='S';break;
			case 1: ch='H';break;
			case 2: ch='C';break;
			case 3: ch='D';break;
			}
			cout<<ch<<" "<<p+1<<endl;
		}
		}
	}
return 0;
}