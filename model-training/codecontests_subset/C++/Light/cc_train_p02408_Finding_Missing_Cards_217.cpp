#include<iostream>
using namespace std;
int main(){
    int a,i,j,n;
    int num;
    bool cards[4][13] = {false};
    char pat;
    char pattern[4] = {'S','H','C','D'};
    cin>>n;

    for(a=0;a<n;a++){
        cin>>pat>>num;    
        for(j=0;j<4;j++){
            if(pat==pattern[j]){
                cards[j][num-1] = true;
                break;
            }   
        }
    }

    for(i=0;i<4;i++){
        for(j=0;j<13;j++){
            if(!cards[i][j]){
                cout<<pattern[i]<<" "<<j+1<<endl;
            }
        }
    }
    return 0;
}
