#include<bits/stdc++.h>
using namespace std;

int main(){
int n;
cin>>n;
int card[100][100];

for(int i=0;i<n;i++){
int num;
string mark;
cin>>mark>>num;

int g;
if (mark=="S") {g=1;}
if (mark=="H") {g=2;}
if (mark=="C") {g=3;}
if (mark=="D") {g=4;}
card[g][num]=1;
}

string str[5]={"G","S","H","C","D"};
for(int x=1;x<=4;x++){
for(int y=1;y<=13;y++){

	if(card[x][y]==1){continue;}
	else{
	cout<<str[x]<<" "<<y<<endl;
	}

}
}


return 0;
}
