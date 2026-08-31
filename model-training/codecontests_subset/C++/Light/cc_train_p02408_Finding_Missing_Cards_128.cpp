#include<iostream>
#include<utility>
#include<vector>
#include<set>
using namespace std ;

int main(){
    int n ; cin >> n ;
    set<pair<char,int>> card ;
    for(int i=0;i<n;i++){
        pair<char,int> sub ;
        cin >> sub.first >> sub.second ;
        card.insert(sub) ;
    }
    vector<char> mark = {'S','H','C','D'} ;
    for(int i=0;i<4;i++){
        for(int j=0;j<13;j++){
            pair<char,int> sub = make_pair(mark.at(i),j+1) ;
            if(!card.count(sub)) cout << mark.at(i) << " " << j+1 << endl ;
        }
    }
}
