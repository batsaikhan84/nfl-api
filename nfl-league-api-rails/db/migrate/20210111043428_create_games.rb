class CreateGames < ActiveRecord::Migration[6.0]
  def change
    create_table :games do |t|
      t.string :home_team
      t.string :away_team
      t.string :season
      t.string :season_type
      t.string :location
      t.string :week
      t.string :startTime
      t.string :endTime

      t.timestamps
    end
  end
end
